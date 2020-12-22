package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.repository.AuditLogRepository;
import com.app.repository.BranchRepository;
import com.app.repository.ChargesRepository;
import com.app.repository.CompoundingPeriodRepository;
import com.app.repository.CountryRepository;
import com.app.repository.DepositTypeRepository;
import com.app.repository.DistrictRepository;
import com.app.repository.FeaturesRepository;
import com.app.repository.FeeParameterRepository;
import com.app.repository.FinancialYearRepository;
import com.app.repository.HolidayListRepository;
import com.app.repository.IpAddressRepository;
import com.app.repository.LateFeeParameterRepository;
import com.app.repository.MemberTypeRepository;
import com.app.repository.ModulesRepository;
import com.app.repository.NewsRepository;
import com.app.repository.PrivilegeRepository;
import com.app.repository.RelationshipRepository;
import com.app.repository.RolesRepository;
import com.app.repository.SbAccountsParametersRepository;
import com.app.repository.SbTypeRepository;
import com.app.repository.ServiceCenterRepository;
import com.app.repository.ServiceCenterUserRepository;
import com.app.repository.ShareParameterRepository;
import com.app.repository.StateRepository;
import com.app.repository.TalukRepository;
import com.app.repository.UsersRepository;

@Component
public class AutoManager {
	

	@Autowired
	public EncryptionAndDecryption encryptionAndDecryption;

	@Autowired
	public StateRepository state;
	
	@Autowired
	public UsersRepository users;
	
	@Autowired
	public DistrictRepository district;
	
	@Autowired
	public NewsRepository news;
	
	@Autowired
	public FinancialYearRepository financialYear;
	
	@Autowired
	public BranchRepository branch;
	
	@Autowired
	public IpAddressRepository ipAddress;
	
	@Autowired
	public ServiceCenterRepository  serviceCenter;
	
	@Autowired
	public ServiceCenterUserRepository serviceCenterUser;
	
	@Autowired
	public CountryRepository country;
	
	@Autowired
	public ModulesRepository modules;
	
	@Autowired
	public FeaturesRepository features;
	
	@Autowired
	public RolesRepository roles;
	
	@Autowired
	public PrivilegeRepository privilege;
	
	@Autowired
	public RelationshipRepository relationship;
	
	@Autowired
	public MemberTypeRepository memberType;
	
	@Autowired
	public ShareParameterRepository shareParameter;
	
	@Autowired
	public FeeParameterRepository feeParameter;
	
	@Autowired
	public SbTypeRepository sbType;
	
	@Autowired
	public SbAccountsParametersRepository sbAccountsParameters;	
	
	@Autowired
	public DepositTypeRepository depositType;
	
	
	@Autowired
	public CompoundingPeriodRepository compoundingPeriod;
	
	@Autowired
	public HolidayListRepository holidayList;
	
	@Autowired
	public LateFeeParameterRepository lateFeeParameter;
	
	@Autowired
	public ChargesRepository charges;
	
	@Autowired
	public TalukRepository taluk;
	
	@Autowired
	public AuditLogRepository auditLog;
	
}
