package com.app.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.entity.Branch;
import com.app.entity.Country;
import com.app.entity.District;
import com.app.entity.FinancialYear;
import com.app.entity.IpAddress;
import com.app.entity.News;
import com.app.entity.Relationship;
import com.app.entity.ServiceCenter;
import com.app.entity.ServiceCenterUser;
import com.app.entity.State;
import com.app.entity.Taluk;
import com.app.entity.Users;
import com.app.exception.BankRestException.DELETE_FAILED;
import com.app.exception.BankRestException.DUPLICATE_KEY;
import com.app.exception.BankRestException.NOT_FOUND;
import com.app.exception.BankRestException.UPDATE_FAILED;
import com.app.request.CommonRequest;
import com.app.request.UserRequest;
import com.app.service.MasterService;
import com.app.util.AutoManager;

@Service
public class MasterImpl extends AutoManager implements MasterService {

	private static Logger logger = LoggerFactory.getLogger("master-log");

	@Override
	public Map<String, String> createState(CommonRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {

			Optional<Country> datas = super.country.findBySlno(request.getCountry());
			if (request.getCountry() == null || !datas.isPresent()) {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}

			List<State> tasks = new ArrayList<State>();
			tasks = super.state.findByNameAndCountrySlno(request.getName().trim(), request.getCountry());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "state name already exists");
				return info;
			}
			Date date = new Date();
			State data = new State();
			data.setName(request.getName());
			data.setCountry(datas.get());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.state.save(data);

			info.put("status", "1");
			info.put("message", "State created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("error", e.toString());
			return info;
		}

	}

	@Override
	public Map<String, Object> getState() {
		Map<String, Object> info = new LinkedHashMap<>();

		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<State> tasks = super.state.findAll();
			for (State t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("countrySlno", t.getCountry().getSlno());
				result.put("countryName", t.getCountry().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> updateState(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<State> data = super.state.findBySlnoValue(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "State slno not present");
				return info;
			}

			Optional<Country> countrys = super.country.findBySlno(request.getCountry());
			if (request.getCountry() == null || !countrys.isPresent()) {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}

			List<State> tasks = new ArrayList<State>();
			tasks = super.state.findByNameAndCountrySlno(request.getName().trim(), request.getCountry());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "State name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.state.updateStateRecord(request.getName(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getCountry(),
					request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "State updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "State slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteState(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<State> data = super.state.findBySlnoValue(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "State slno not present");
				return info;
			}

			int retval = super.state.deleteStateRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "State deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "State slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

	@Override
	public Map<String, Object> getStateBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {

			LinkedList<Object> datalist = new LinkedList();

			Iterable<State> tasks = super.state.findBySlno(request.getSlno());
			for (State t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("countrySlno", t.getCountry().getSlno());
				result.put("countryName", t.getCountry().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, String> createdistrict(CommonRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			Optional<State> tasks = super.state.findBySlnoValue(request.getState());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "State  not present");
				return info;
			}

			List<District> result = new ArrayList<District>();
			result = super.district.findByName(request.getName().trim());
			if (result.size() > 0) {
				info.put("status", "2");
				info.put("message", "District name already exists");
				return info;
			}
			Date date = new Date();
			District data = new District();
			data.setName(request.getName());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			data.setState(tasks.get());
			data.setDescription(request.getDescription());
			super.district.save(data);

			info.put("status", "1");
			info.put("message", "District created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> getdistrict() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<District> tasks = super.district.findAll();
			for (District t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());
				result.put("description", t.getDescription());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("stateSlno", t.getState().getSlno());
				result.put("stateName", t.getState().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getdistrictBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<District> tasks = super.district.findBySlno(request.getSlno());
			for (District t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());
				result.put("description", t.getDescription());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("stateSlno", t.getState().getSlno());
				result.put("stateName", t.getState().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deletedistrict(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<District> data = super.district.findBySlnoValue(request.getSlno());
			if (!data.isPresent()) {
				info.put("status", "2");
				info.put("message", "District slno not present");
				return info;
			}

			int retval = super.district.deleteDistrictRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "District deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "District slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updatedistrict(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<District> data = super.district.findBySlnoValue(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "District slno not present");
				return info;
			}
			Optional<State> res = super.state.findBySlnoValue(request.getState());
			if (!res.isPresent()) {
				info.put("status", "2");
				info.put("message", "State  not present");
				return info;
			}

			List<District> tasks = new ArrayList<District>();
			tasks = super.district.findByName(request.getName().trim());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "District name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.district.updateDistrictRecord(request.getName(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getDescription(),
					request.getState(), request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "District updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "District slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, String> createnews(CommonRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			List<News> tasks = new ArrayList<News>();
			tasks = super.news.findByTitle(request.getTitle().trim());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "News title already exists");
				return info;
			}

			SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
			Date newdate = formate.parse(request.getNewsDate());

			Date date = new Date();
			News data = new News();
			data.setTitle(request.getTitle());
			data.setActive(request.getActive());
			data.setDescription(request.getDescription());
			data.setNewsDate(new java.sql.Date(newdate.getTime()));
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.news.save(data);

			info.put("status", "1");
			info.put("message", "News created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, String> createusers(@Valid UserRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			String dcrypt = super.encryptionAndDecryption.getDecryptedStringaddhexkey(request.getPassword().trim());

			List<Users> tasks = new ArrayList<Users>();
			tasks = super.users.findByUsername(request.getUsername().trim());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "username already exists");
				return info;
			}
			Date date = new Date();
			Users data = new Users();
			data.setName(request.getName());
			data.setUsername(request.getUsername());
			data.setEmailId(request.getEmailId());
			data.setAddress(request.getAddress());
			data.setMobile(request.getMobile());
			data.setPassword(dcrypt);
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());

			super.users.save(data);

			info.put("status", "1");
			info.put("message", "User created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getnews() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Iterable<News> tasks = super.news.findAll();
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> getnewsBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<News> tasks = super.news.findBySlno(request.getSlno());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "News slno not present");
				return info;
			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deletenews(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<News> data = super.news.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "News slno not present");
				return info;
			}

			int retval = super.news.deleteNewsRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "News deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "State slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updatenews(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<News> data = super.news.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "News  not present");
				return info;
			}
			SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
			Date newdate = formate.parse(request.getNewsDate());

			List<News> tasks = new ArrayList<News>();
			tasks = super.news.findByTitleAndNewsDate(request.getTitle().trim(), new java.sql.Date(newdate.getTime()));
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "News Title with particular date already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.news.updateNewsRecord(request.getTitle(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getDescription(),
					new java.sql.Date(newdate.getTime()), request.getActive(), request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "News updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "News  not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> createFinancialYear(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			List<FinancialYear> tasks = new ArrayList<FinancialYear>();
			tasks = super.financialYear.findByFromYearAndToYear(request.getFromYear().trim(), request.getToYear());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "FinancialYear already exists");
				return info;
			}
			Date date = new Date();
			FinancialYear data = new FinancialYear();
			data.setFromYear(request.getFromYear());
			data.setToYear(request.getToYear());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.financialYear.save(data);

			info.put("status", "1");
			info.put("message", "FinancialYear created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getFinancialYear() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Iterable<FinancialYear> tasks = super.financialYear.findAll();
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getFinancialYearBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<FinancialYear> tasks = super.financialYear.findBySlno(request.getSlno());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "FinancialYear  not present");
				return info;
			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updateFinancialYear(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<FinancialYear> data = super.financialYear.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "FinancialYear not present");
				return info;
			}

			List<FinancialYear> tasks = new ArrayList<FinancialYear>();
			tasks = super.financialYear.findByFromYearAndToYear(request.getFromYear(), request.getToYear());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "FinancialYear already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.financialYear.updateFinancialYearRecord(request.getFromYear(), request.getToYear(),
					request.getModifiedBy(), new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()),
					request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "FinancialYear updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "FinancialYear not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteFinancialYear(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<FinancialYear> data = super.financialYear.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "FinancialYear not present");
				return info;
			}

			int retval = super.financialYear.deleteStateRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "FinancialYear deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "FinancialYear not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}
// branch

	@Override
	public String createBranch(CommonRequest request) throws Exception {
		logger.info("Inside createBranch" + request);

		Optional<State> datas = super.state.findBySlnoValue(request.getState());
		if (request.getState() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Satate is not present");
		}

		Optional<District> dist = super.district.findBySlnoValue(request.getDistrict());
		if (request.getDistrict() == null || !dist.isPresent()) {
			throw new NOT_FOUND("District is not present");
		}
		Optional<Taluk> talk = super.taluk.findBySlno(request.getTaluk());
		if (request.getTaluk() == null || !talk.isPresent()) {
			throw new NOT_FOUND("District is not present");
		}

		List<Branch> res = new ArrayList<Branch>();
		res = super.branch.findByNameAndStateSlnoAndDistrictSlnoAndTalukSlno(request.getName().trim(),
				request.getState(), request.getDistrict(), request.getTaluk());
		if (res.size() > 0) {
			throw new DUPLICATE_KEY("Branch already  exists");
		}
		Date date = new Date();
		Branch data = new Branch();
		data.setName(request.getName());
		data.setEmailId(request.getEmailId());
		data.setAddress(request.getAddress());
		data.setMobileNo(request.getMobileNo());
		data.setPhoneNo(request.getPhoneNo());
		data.setPincode(request.getPincode());
		data.setContactName(request.getContactName());
		data.setCode(request.getCode());
		data.setIsActive(request.getIsActive());
		data.setState(datas.get());
		data.setDistrict(dist.get());
		data.setTaluk(talk.get());
		data.setCity(request.getCity());

		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(request.getCreatedBy());
		super.branch.save(data);
		logger.info("Branch created successfully" + data);
		return "Branch created successfully";
	}

	@Override
	public Object getBranch() throws Exception {
		
		logger.info("Inside getBranchBySlno");
		
		LinkedList<Object> datalist = new LinkedList();

		Iterable<Branch> list = super.branch.findAll();
		for (Branch t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("name", t.getName());
			result.put("contactName", t.getContactName());
			result.put("code", t.getCode());
			result.put("mobileNo", t.getMobileNo());
			result.put("phoneNo", t.getPhoneNo());
			result.put("pincode", t.getPincode());
			result.put("address", t.getAddress());
			result.put("emailId", t.getEmailId());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("stateSlno", t.getState().getSlno());
			result.put("districtSlno", t.getDistrict().getSlno());
			result.put("taluk", t.getTaluk().getSlno());
			result.put("talukName", t.getName());
			datalist.add(result);
		}

		return datalist;
	}

	@Override
	public Object getBranchBySlno(CommonRequest request) throws Exception {
		logger.info("Inside getBranchBySlno" + request);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<Branch> list = super.branch.findByBranchSlno(request.getSlno());
		for (Branch t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("name", t.getName());
			result.put("contactName", t.getContactName());
			result.put("code", t.getCode());
			result.put("mobileNo", t.getMobileNo());
			result.put("phoneNo", t.getPhoneNo());
			result.put("pincode", t.getPincode());
			result.put("address", t.getAddress());
			result.put("emailId", t.getEmailId());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("stateSlno", t.getState().getSlno());
			result.put("districtSlno", t.getDistrict().getSlno());
			result.put("taluk", t.getTaluk().getSlno());
			result.put("talukName", t.getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateBranch(CommonRequest request) throws Exception {
		logger.info("Inside updateBranch" + request);

		Optional<Branch> task = super.branch.findBySlnoValue(request.getSlno());
		if (request.getSlno() == null || !task.isPresent()) {
			throw new NOT_FOUND("Branch is not present");
		}
		
		
		Optional<State> datas = super.state.findBySlnoValue(request.getState());
		if (request.getState() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Satate is not present");
		}

		Optional<District> dist = super.district.findBySlnoValue(request.getDistrict());
		if (request.getDistrict() == null || !dist.isPresent()) {
			throw new NOT_FOUND("District is not present");
		}

		Optional<Taluk> data = super.taluk.findBySlno(request.getTaluk());
		if (request.getTaluk() == null || !data.isPresent()) {
			throw new NOT_FOUND("Taluk is not present");
		}

		Date date = new Date();
		int retval = super.branch.updateBranchRecord(request.getName(), request.getModifiedBy(),
				new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getAddress(),
				request.getState(), request.getCode(), request.getContactName(), request.getPincode(),
				request.getPhoneNo(), request.getMobileNo(), request.getEmailId(),request.getDistrict(),request.getTaluk(),request.getCity(),request.getIsActive(), request.getSlno());
		if (retval == 1) {
			logger.info("Branch updated successfully" + data);
			return "Branch updated successfully";
		}
		throw new UPDATE_FAILED("Branch  updated Failed");
	}

	@Override
	public Object deleteBranch(CommonRequest request) throws Exception {
		logger.info("Inside deleteBranch" + request);
		Optional<Branch> data = super.branch.findBySlno(request.getSlno());
		if (request.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Branch is not present");
		}
		int retval = super.branch.deleteBranchRecord(request.getSlno());
		if (retval == 1) {
			logger.info("Branch deleted successfully" + data);
			return "Branch deleted successfully";
		}
		throw new DELETE_FAILED("Branch  deleted failed");
	}
	
		

	@Override
	public Map<String, Object> changePassword(UserRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {

			if (!request.getNewPassword().equals(request.getConfirmPassword())) {
				info.put("status", "2");
				info.put("message", "NewPassword and ConfirmPassword are not same");
				return info;
			}

			String newpassworddcrypt = encryptionAndDecryption
					.getDecryptedStringaddhexkey(request.getNewPassword().trim());
			System.out.println(">>>>>>>" + newpassworddcrypt);
			String oldpassworddcrypt = encryptionAndDecryption
					.getDecryptedStringaddhexkey(request.getOldPassword().trim());
			System.out.println(">>>>>>>" + oldpassworddcrypt);

			List<Users> task = super.users.findByUsernameAndPassword(request.getUsername(), oldpassworddcrypt);
			if (task.size() > 0) {

				int updatresult = super.users.updateusersPassword(newpassworddcrypt, request.getUsername());
				if (updatresult == 0) {
					info.put("status", "2");
					info.put("message", "Something went wrong");
					return info;
				}
				info.put("status", "1");
				info.put("message", "User Password  updated successfully");
				return info;

			}
			info.put("status", "2");
			info.put("message", "Username doesnot match with oldpassword");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> createIpAddress(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Branch> tasks = super.branch.findBySlnoValue(request.getBranch());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch slno not present");
				return info;
			}

			List<IpAddress> result = new ArrayList<IpAddress>();
			result = super.ipAddress.findByIpAddressAndBranchSlno(request.getIpAddress().trim(), request.getBranch());
			if (result.size() > 0) {
				info.put("status", "2");
				info.put("message", "IpAddress  already exists");
				return info;
			}
			Date date = new Date();
			IpAddress data = new IpAddress();
			data.setIpAddress(request.getIpAddress());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			data.setBranch(tasks.get());
			data.setIsActive(request.getIsActive());
			super.ipAddress.save(data);

			info.put("status", "1");
			info.put("message", "IpAddress created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getIpAddress() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<IpAddress> tasks = super.ipAddress.findAll();
			for (IpAddress t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("ipAddress", t.getIpAddress());
				result.put("isActive", t.getIsActive());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getIpAddressBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<IpAddress> tasks = super.ipAddress.findBySlno(request.getSlno());
			for (IpAddress t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("ipAddress", t.getIpAddress());
				result.put("isActive", t.getIsActive());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updateIpAddress(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<IpAddress> data = super.ipAddress.findBySlnoValue(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "IpAddress slno not present");
				return info;
			}
			Optional<Branch> res = super.branch.findBySlnoValue(request.getBranch());
			if (!res.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}

			List<IpAddress> tasks = new ArrayList<IpAddress>();
			tasks = super.ipAddress.findByIpAddressAndBranchSlno(request.getIpAddress().trim(), request.getBranch());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "IpAddress  already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.ipAddress.updateIpAddressRecord(request.getIpAddress(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getIsActive(),
					request.getBranch(), request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "IpAddress updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "IpAddress not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteIpAddress(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<IpAddress> data = super.ipAddress.findBySlnoValue(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "IpAddress not present");
				return info;
			}

			int retval = super.ipAddress.deleteIpAddressRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "IpAddress deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "IpAddress not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

	@Override
	public Map<String, Object> IpAddressbasedOnStatus(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<IpAddress> tasks = super.ipAddress.findByIsActive(request.getIsActive());
			for (IpAddress t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("ipAddress", t.getIpAddress());
				result.put("isActive", t.getIsActive());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> createServiceCenter(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();

		try {
			Optional<State> tasks = super.state.findBySlnoValue(request.getState());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "State  not present");
				return info;
			}
			Optional<Branch> res = super.branch.findBySlnoValue(request.getBranch());
			if (!res.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}

			List<ServiceCenter> det = new ArrayList<ServiceCenter>();
			det = super.serviceCenter.findByNameAndStateSlnoAndBranchSlno(request.getName().trim(), request.getState(),
					request.getBranch());
			if (det.size() > 0) {
				info.put("status", "2");
				info.put("message", "ServiceCenter Name already exists");
				return info;
			}
			Date date = new Date();
			ServiceCenter data = new ServiceCenter();
			data.setName(request.getName());
			data.setEmailId(request.getEmailId());
			data.setAddress(request.getAddress());
			data.setMobileNo(request.getMobileNo());
			data.setPhoneNo(request.getPhoneNo());
			data.setPincode(request.getPincode());
			data.setContactName(request.getContactName());
			data.setCode(request.getCode());
			data.setState(tasks.get());
			data.setBranch(res.get());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.serviceCenter.save(data);

			info.put("status", "1");
			info.put("message", "ServiceCenter created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> getServiceCenter() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<ServiceCenter> tasks = super.serviceCenter.findAll();
			for (ServiceCenter t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());
				result.put("contactName", t.getContactName());
				result.put("code", t.getCode());
				result.put("mobileNo", t.getMobileNo());
				result.put("phoneNo", t.getPhoneNo());
				result.put("pincode", t.getPincode());
				result.put("address", t.getAddress());
				result.put("emailId", t.getEmailId());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("stateSlno", t.getState().getSlno());
				result.put("stateName", t.getState().getName());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());

				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getServiceCenterBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<ServiceCenter> tasks = super.serviceCenter.findBySlnoValue(request.getSlno());
			for (ServiceCenter t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("name", t.getName());
				result.put("contactName", t.getContactName());
				result.put("code", t.getCode());
				result.put("mobileNo", t.getMobileNo());
				result.put("phoneNo", t.getPhoneNo());
				result.put("pincode", t.getPincode());
				result.put("address", t.getAddress());
				result.put("emailId", t.getEmailId());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("stateSlno", t.getState().getSlno());
				result.put("stateName", t.getState().getName());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());

				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updateServiceCenter(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {

			Optional<ServiceCenter> datavalues = super.serviceCenter.findBySlno(request.getSlno());
			if (request.getSlno() == null || !datavalues.isPresent()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter  not present");
				return info;
			}

			Optional<Branch> data = super.branch.findBySlnoValue(request.getBranch());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}
			Optional<State> res = super.state.findBySlnoValue(request.getState());
			if (!res.isPresent()) {
				info.put("status", "2");
				info.put("message", "State  not present");
				return info;
			}

			List<ServiceCenter> tasks = new ArrayList<ServiceCenter>();
			tasks = super.serviceCenter.findByNameAndStateSlnoAndBranchSlno(request.getName().trim(),
					request.getState(), request.getBranch());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.serviceCenter.updateServiceCenterRecord(request.getName(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getAddress(),
					request.getState(), request.getCode(), request.getContactName(), request.getPincode(),
					request.getPhoneNo(), request.getMobileNo(), request.getEmailId(), request.getBranch(),
					request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "ServiceCenter updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "ServiceCenter not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteServiceCenter(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<ServiceCenter> data = super.serviceCenter.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter not present");
				return info;
			}

			int retval = super.serviceCenter.deleteStateRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "ServiceCenter deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "ServiceCenter  not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

	@Override
	public Map<String, Object> createserviceCenterUser(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();

		try {
			Optional<Branch> tasks = super.branch.findBySlnoValue(request.getBranch());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}
			Optional<ServiceCenter> task = super.serviceCenter.findBySlno(request.getServiceCenter());
			if (!task.isPresent()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter  not present");
				return info;
			}
			List<ServiceCenterUser> res = new ArrayList<ServiceCenterUser>();
			res = super.serviceCenterUser.findByAccountNo(request.getAccountNo());
			if (res.size() > 0) {
				info.put("status", "2");
				info.put("message", "AccountNo already exists");
				return info;
			}

			List<ServiceCenterUser> usernames = new ArrayList<ServiceCenterUser>();
			res = super.serviceCenterUser.findByUsername(request.getUsername());
			if (usernames.size() > 0) {
				info.put("status", "2");
				info.put("message", "Username already exists");
				return info;
			}

			String dcrypt = super.encryptionAndDecryption.getDecryptedStringaddhexkey(request.getPassword().trim());

			Date date = new Date();

			ServiceCenterUser data = new ServiceCenterUser();
			data.setUsername(request.getUsername());
			data.setEmailId(request.getEmailId());
			data.setAddress(request.getAddress());
			data.setMobileNo(request.getMobileNo());
			data.setPhoneNo(request.getPhoneNo());
			data.setPincode(request.getPincode());
			data.setContactName(request.getContactName());
			data.setAccountNo(request.getAccountNo());
			data.setPassword(dcrypt);
			data.setServiceCenter(task.get());
			data.setBranch(tasks.get());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.serviceCenterUser.save(data);

			info.put("status", "1");
			info.put("message", "ServiceCenter User created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> getServiceCenterUser() {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<ServiceCenterUser> tasks = super.serviceCenterUser.findAll();
			for (ServiceCenterUser t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("username", t.getUsername());
				result.put("contactName", t.getContactName());
				result.put("accountNo", t.getAccountNo());
				result.put("mobileNo", t.getMobileNo());
				result.put("phoneNo", t.getPhoneNo());
				result.put("pincode", t.getPincode());
				result.put("address", t.getAddress());
				result.put("emailId", t.getEmailId());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());

				result.put("serviceCenterSlno", t.getServiceCenter().getSlno());
				result.put("serviceCenterName", t.getServiceCenter().getName());

				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> getServiceCenterUserBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			LinkedList<Object> datalist = new LinkedList();

			Iterable<ServiceCenterUser> tasks = super.serviceCenterUser.findBySlno(request.getSlno());
			for (ServiceCenterUser t : tasks) {
				HashMap<String, Object> result = new HashMap<>();
				result.put("slno", t.getSlno());
				result.put("username", t.getUsername());
				result.put("contactName", t.getContactName());
				result.put("accountNo", t.getAccountNo());
				result.put("mobileNo", t.getMobileNo());
				result.put("phoneNo", t.getPhoneNo());
				result.put("pincode", t.getPincode());
				result.put("address", t.getAddress());
				result.put("emailId", t.getEmailId());

				result.put("createdBy", t.getCreatedBy());
				result.put("createdAt", t.getCreatedAt());
				result.put("createdOn", t.getCreatedOn());

				result.put("modifiedBy", t.getModifiedBy());
				result.put("modifiedAt", t.getModifiedAt());
				result.put("modifiedOn", t.getModifiedOn());

				result.put("branchSlno", t.getBranch().getSlno());
				result.put("branchName", t.getBranch().getName());

				result.put("serviceCenterSlno", t.getServiceCenter().getSlno());
				result.put("serviceCenterName", t.getServiceCenter().getName());
				datalist.add(result);

			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", datalist);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updateServiceCenterUser(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Branch> data = super.branch.findBySlnoValue(request.getBranch());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}
			Optional<ServiceCenter> res = super.serviceCenter.findBySlno(request.getServiceCenter());
			if (!res.isPresent()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter  not present");
				return info;
			}

			List<ServiceCenterUser> tasks = new ArrayList<ServiceCenterUser>();
			tasks = super.serviceCenterUser.findByAccountNo(request.getAccountNo());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "AccountNo  already exists");
				return info;
			}

			List<ServiceCenterUser> username = new ArrayList<ServiceCenterUser>();
			username = super.serviceCenterUser.findByUsername(request.getUsername());
			if (username.size() > 0 && username.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "Username  already exists");
				return info;
			}

			String dcrypt = super.encryptionAndDecryption.getDecryptedStringaddhexkey(request.getPassword().trim());

			Date date = new Date();
			int retval = super.serviceCenterUser.updateserviceCenterUserRecord(request.getUsername(),
					request.getModifiedBy(), new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()),
					request.getAddress(), request.getBranch(), dcrypt, request.getContactName(), request.getPincode(),
					request.getPhoneNo(), request.getMobileNo(), request.getEmailId(), request.getAccountNo(),
					request.getServiceCenter(), request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "ServiceCenter User updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "ServiceCenter User not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteServiceCenterUser(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<ServiceCenterUser> data = super.serviceCenterUser.findBySlnoValue(request.getSlno());
			if (!data.isPresent()) {
				info.put("status", "2");
				info.put("message", "ServiceCenter User not present");
				return info;
			}

			int retval = super.serviceCenterUser.deleteBranchRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "ServiceCenter User deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "ServiceCenter User not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> enableORDisableOnBranch(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Branch> data = super.branch.findBySlnoValue(request.getBranch());
			if (request.getBranch() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Branch  not present");
				return info;
			}

			String value = request.getIsActive() == true ? " Enabled " : " Disabled ";

			Date date = new Date();
			int retval = super.ipAddress.updateenableORDisableOnBranch(request.getIsActive(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getBranch());

			if (retval >= 1) {
				info.put("status", "1");
				info.put("message", "Ip Address" + value + "Successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Ip Address not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, String> createCountry(CommonRequest request) {
		Map<String, String> info = new LinkedHashMap<>();
		try {
			List<Country> tasks = new ArrayList<Country>();
			tasks = super.country.findByName(request.getName().trim());
			if (tasks.size() > 0) {
				info.put("status", "2");
				info.put("message", "Country name already exists");
				return info;
			}
			Date date = new Date();
			Country data = new Country();
			data.setName(request.getName());
			data.setCreatedOn(new java.sql.Date(date.getTime()));
			data.setCreatedAt(new java.sql.Time(date.getTime()));
			data.setCreatedBy(request.getCreatedBy());
			super.country.save(data);

			info.put("status", "1");
			info.put("message", "Country created successfully");
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("error", e.toString());
			return info;
		}

	}

	@Override
	public Map<String, Object> getCountry(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {

			// Pageable paging = PageRequest.of(request.getPageNo(), request.getPageSize());
			// Page<Country> pagedResult = super.country.findAll(paging);
			Iterable<Country> tasks = super.country.findAll();
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}

	}

	@Override
	public Map<String, Object> getCountryBySlno(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Country> tasks = super.country.findBySlno(request.getSlno());
			if (!tasks.isPresent()) {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}
			info.put("status", "1");
			info.put("message", "success");
			info.put("details", tasks);
			return info;

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> updateCountry(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Country> data = super.country.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}

			List<Country> tasks = new ArrayList<Country>();
			tasks = super.country.findByName(request.getName().trim());
			if (tasks.size() > 0 && tasks.get(0).getSlno() != request.getSlno()) {
				info.put("status", "2");
				info.put("message", "Country name already exists");
				return info;
			}
			Date date = new Date();
			int retval = super.country.updateCountryRecord(request.getName(), request.getModifiedBy(),
					new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()), request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Country updated successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Country slno not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;

		}
	}

	@Override
	public Map<String, Object> deleteCountry(CommonRequest request) {
		Map<String, Object> info = new LinkedHashMap<>();
		try {
			Optional<Country> data = super.country.findBySlno(request.getSlno());
			if (request.getSlno() == null || !data.isPresent()) {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}

			int retval = super.country.deleteCountryRecord(request.getSlno());
			if (retval == 1) {
				info.put("status", "1");
				info.put("message", "Country deleted successfully");
				return info;
			} else {
				info.put("status", "2");
				info.put("message", "Country  not present");
				return info;
			}

		} catch (Exception e) {
			logger.error("Exception occured" + e);
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.error(errors.toString());
			info.put("status", "0");
			info.put("message", "Something went wrong");
			return info;
		}
	}

//	taluk

	@Override
	public String createTaluk(CommonRequest request) throws Exception {
		logger.info("Inside Taluk" + request);

		Optional<State> datas = super.state.findBySlnoValue(request.getState());
		if (request.getState() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Satate is not present");
		}

		Optional<District> dist = super.district.findBySlnoValue(request.getDistrict());
		if (request.getDistrict() == null || !dist.isPresent()) {
			throw new NOT_FOUND("District is not present");
		}
	
		List<Taluk> val = super.taluk.findByName(request.getName());
		if (val.size() > 0) {
			throw new DUPLICATE_KEY("Taluk already  exists");
		}
		
		Date date = new Date();
		Taluk data = new Taluk();
		data.setState(datas.get());
		data.setDistrict(dist.get());
		data.setName(request.getName());
		data.setCreatedOn(new java.sql.Date(date.getTime()));
		data.setCreatedAt(new java.sql.Time(date.getTime()));
		data.setCreatedBy(request.getCreatedBy());
		super.taluk.save(data);
		logger.info("Taluk created successfully" + data);
		return "Taluk created successfully";
	}

	@Override
	public Object getTaluk(CommonRequest request) throws Exception {
		LinkedList<Object> datalist = new LinkedList();

		Iterable<Taluk> list = super.taluk.findAll();
		for (Taluk t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("name", t.getName());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("stateSlno", t.getState().getSlno());
			result.put("stateName", t.getState().getName());
			result.put("districtSlno", t.getDistrict().getSlno());
			result.put("districtName", t.getDistrict().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object getTalukBySlno(CommonRequest request) throws Exception {
		logger.info("Inside Taluk" + request);
		LinkedList<Object> datalist = new LinkedList();

		Iterable<Taluk> list = super.taluk.findByTalukSlno(request.getSlno());
		for (Taluk t : list) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("slno", t.getSlno());
			result.put("name", t.getName());

			result.put("createdBy", t.getCreatedBy());
			result.put("createdAt", t.getCreatedAt());
			result.put("createdOn", t.getCreatedOn());

			result.put("modifiedBy", t.getModifiedBy());
			result.put("modifiedAt", t.getModifiedAt());
			result.put("modifiedOn", t.getModifiedOn());

			result.put("stateSlno", t.getState().getSlno());
			result.put("stateName", t.getState().getName());
			result.put("districtSlno", t.getDistrict().getSlno());
			result.put("districtName", t.getDistrict().getName());
			datalist.add(result);
		}
		return datalist;
	}

	@Override
	public Object updateTaluk(CommonRequest request) throws Exception {
		logger.info("Inside Taluk" + request);

		Optional<State> datas = super.state.findBySlnoValue(request.getState());
		if (request.getState() == null || !datas.isPresent()) {
			throw new NOT_FOUND("Satate is not present");
		}

		Optional<District> dist = super.district.findBySlnoValue(request.getDistrict());
		if (request.getDistrict() == null || !dist.isPresent()) {
			throw new NOT_FOUND("District is not present");
		}

		Optional<Taluk> data = super.taluk.findBySlno(request.getSlno());
		if (request.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Taluk is not present");
		}

		Date date = new Date();
		int retval = super.taluk.updateTalukRecord(request.getName(), request.getDistrict(), request.getState(),
				request.getModifiedBy(), new java.sql.Date(date.getTime()), new java.sql.Time(date.getTime()),
				request.getSlno());
		if (retval == 1) {
			return "Taluk updated successfully";
		}
		throw new UPDATE_FAILED("Taluk  updated Failed");
	}

	@Override
	public Object deleteTaluk(CommonRequest request) throws Exception {
		logger.info("Inside Taluk" + request);
		Optional<Taluk> data = super.taluk.findBySlno(request.getSlno());
		if (request.getSlno() == null || !data.isPresent()) {
			throw new NOT_FOUND("Taluk is not present");
		}
		int retval = super.taluk.deleteTalukRecord(request.getSlno());
		if (retval == 1) {
			return "Taluk deleted successfully";
		}
		throw new DELETE_FAILED("Taluk  deleted failed");
	}

	// Bod;

//		@Override
//		public String createBod(CommonRequest request) {
//			Map<String, String> info = new LinkedHashMap<>();						
//				Date date = new Date();
//				Bod data = new Bod();
//				data.setBod(request.getBod());
//				data.setCreatedOn(new java.sql.Date(date.getTime()));
//				data.setCreatedAt(new java.sql.Time(date.getTime()));
//				data.setCreatedBy(request.getCreatedBy());
//				super.bod.save(data);
//				return "Country created successfully";
//			
//		}
//		

}
