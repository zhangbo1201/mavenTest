package cn.edu.hhit.service.AdapterPattern;

import java.util.Map;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2218:15
 */
public class OuterUserInfo extends OutUser implements IUserInfo{
    private Map<String,String> baseInfo = super.getUserBaseInfo(); //员工的基本信息
    private Map<String,String> officeInfo = super.getUserOfficeInfo(); //工作信息
    private Map<String,String> homeInfo = super.getUserHomeInfo(); //员工的家庭信息

    /**
     * 家庭地址
     */
    public String getHomeAddress() {
        String homeAddress =  this.homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    /**
     * 家庭电话号码
     */
    public String getHomeTelNumber() {
        String homeTelNumber =  this.homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }

    /**
     * 职位信息
     */
    public String getJobPosition() {
        String jobPosition =  this.officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    /**
     * 手机号码
     */
    public String getMobileNumber() {
        String mobileNumber =  this.baseInfo.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    /**
     * 办公电话
     */
    public String getOfficeTelNumber() {
        String officeTelNumber = this.officeInfo.get("officeTelNumbe");
                System.out.println(officeTelNumber); return officeTelNumber;
    }

    /**
     * 员工的名称
     */
    public String getUserName() {
        String userName =  this.baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }
}
