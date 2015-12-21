package com.shnlng.frog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shnlng.frog.domain.BindingRepo;
import com.shnlng.frog.domain.CountRepo;
import com.shnlng.frog.domain.MerchantRepo;
import com.shnlng.frog.domain.TargetRepo;
import com.shnlng.frog.domain.entity.BindingEo;
import com.shnlng.frog.domain.entity.CountEo;
import com.shnlng.frog.domain.entity.MerchantEo;
import com.shnlng.frog.domain.entity.TargetEo;
import com.shnlng.frog.util.IdGen;
import com.shnlng.frog.web.message.TalkReq;
import com.shnlng.frog.web.message.TalkReqCount;
import com.shnlng.frog.web.message.TalkResp;
import com.shnlng.frog.web.message.TalkRespItem;

@Service
public class TalkSo {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Autowired
	private CountRepo cRepo;
	@Autowired
	private MerchantRepo mRepo;
	@Autowired
	private TargetRepo tRepo;
	@Autowired
	private BindingRepo bRepo;
	
	@Autowired
	private ResourceSo rSo;

	public void saveCounts(TalkReq talkReq) {
		List<CountEo> countsList = new ArrayList<CountEo>();
		Date today = new Date();

		for (TalkReqCount _c : talkReq.getCounts()) {

			CountEo c = new CountEo();

			c.setCountId(IdGen.id32());
			c.setDeviceId(talkReq.getDid());
			c.setResourceId(_c.getRid());
			c.setCount(_c.getC());
			c.setTime(_c.getT());

			try {
				c.setCountTime(DATE_FORMAT.parse(_c.getCt()));
			} catch (ParseException e) {
				c.setCountTime(today);
			}

			c.setUploadTime(today);

			c.setDisableFlag(0);
			c.setDeleteFlag(0);

			countsList.add(c);
		}

		cRepo.save(countsList);
	}

	public TalkResp replyTalk(TalkReq talkReq){
		TalkResp resp = new TalkResp();
		
		BindingEo b = bRepo.findByDeviceId(talkReq.getDid());
		
		if(b == null){
			return null;
		}
		
		MerchantEo m = mRepo.findOne(b.getMerchantId());
		
		if(m == null){
			return null;
		}
		
		resp.setMid(m.getId());
		resp.setMmaxitems(10);
		resp.setMname(m.getName());
		
		List<TargetEo> targets = tRepo.findByMerchantId(m.getId(), new Date());
		
		if(targets != null && targets.size() > 0){

			List<TalkRespItem> items = new ArrayList<TalkRespItem>();
			
			for(TargetEo _t : targets){
				TalkRespItem i = new TalkRespItem();
				
				i.setRid(_t.getResourceId());
				i.setS(_t.getPlaySequence());
				i.setUrls(rSo.popUrls(_t.getResourceId()));
				
				items.add(i);
			}

			resp.setItems(items);
		}
		
		return resp;
	}
}
