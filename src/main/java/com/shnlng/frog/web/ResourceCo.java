package com.shnlng.frog.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceCo {
	private static Logger logger = Logger.getLogger(ResourceCo.class);

	@Value("${frog.resource.repository.directory}")
	private String fileRepoPath;

	private int bufferSize = 2048;

	@RequestMapping(value = "/res", method = { RequestMethod.GET, RequestMethod.POST })
	public void download(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String rid = req.getParameter("rid");
		if (StringUtils.isEmpty(rid))

		{
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String showFileName = fileRepoPath + File.separator + rid;
		File file = new File(showFileName);

		logger.info("download file id: " + showFileName);

		if (!file.exists())

		{
			logger.info("file not exists");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else

		{
			logger.info("file download starting...");
			resp.reset();
			resp.setHeader("Content-disposition", "attachment;filename=" + rid);

			ServletOutputStream sops = null;
			FileInputStream fis = null;

			try {
				sops = resp.getOutputStream();
				fis = new FileInputStream(file);

				copyStream(fis, sops, true);
			} catch (Exception e) {
				logger.error("closing io" + e.getMessage());
			} finally {
				logger.info("closing io");
				fis.close();
				sops.close();
			}

			fis = null;
			sops = null;
			file = null;
			logger.info("file download completed");
		}

	}

	private final long copyStream(InputStream source, OutputStream dest, boolean flush) {
		int bytes;
		long total = 0l;
		byte[] buffer = new byte[bufferSize];
		try {
			while ((bytes = source.read(buffer)) != -1) {
				if (bytes == 0) {
					bytes = source.read();
					if (bytes < 0)
						break;
					dest.write(bytes);
					if (flush)
						dest.flush();
					total += bytes;
				}
				dest.write(buffer, 0, bytes);
				if (flush)
					dest.flush();
				total += bytes;
			}

		} catch (IOException e) {
			logger.error("file content copying error");
			logger.error(e.getMessage());
			throw new RuntimeException("IOException caught while copying.", e);

		}
		return total;
	}
}
