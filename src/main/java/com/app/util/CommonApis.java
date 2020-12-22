package com.app.util;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.entity.AuditLog;
import com.app.entity.Features;
import com.app.entity.Modules;

@Component
public class CommonApis extends AutoManager {

	public String createAuditLog( long module, long feature, String logedby, String desc, int status) throws Exception {
					
		Optional<Modules> datas = super.modules.findBySlno(module);
		Optional<Features> task = super.features.findBySlno(feature);
		Date date = new Date();
		AuditLog data = new AuditLog();	
		
		data.setModules(datas.get());
		data.setFeatures(task.get());
		data.setStatus(status);
		data.setLogedBy(logedby);
		data.setLogedDate(new java.sql.Date(date.getTime()));
		data.setLogedTime(new java.sql.Time(date.getTime()));
		data.setDescription(desc);
		super.auditLog.save(data);
		return "content Saved in logfile";
	}
}
