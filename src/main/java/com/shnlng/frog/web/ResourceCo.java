package com.shnlng.frog.web;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shnlng.frog.util.FileUtil;

@Controller
public class ResourceCo {
	private static Logger logger = Logger.getLogger(ResourceCo.class);

	@Value("${frog.resource.repository.directory}")
	private String resourceRepoPath;

	@RequestMapping(value = "/res")
	public void download(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String rid = req.getParameter("rid");
		if (StringUtils.isEmpty(rid))

		{
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String showFileName = resourceRepoPath + File.separator + rid;
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

				FileUtil.copyStream(fis, sops, true);
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

}
