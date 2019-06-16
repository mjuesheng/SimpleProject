package com.blog.javabean;

import java.util.Date;

/*
 *    �ʺ���Ϣ��     ����     �ֻ���   �û���   ���� 
 *    �������ϱ�     �ǳ� �������� ����ǩ��  �Ա�
 */
public class PersonBean {
	
	private String email;               //����
	private	String phone;				//�ֻ���
	private String username;			//�û���
	private String password;			//����
	private String name;				//�ǳ�
	private String birthday;				//����
	private String introduce;
	private String sex;					//�Ա�
	private String blood;              //Ѫ��
	
	public PersonBean(){};
	
	public PersonBean(String name,String introduce,String sex,String blood,String email,String phone,String birthday){
		this.name = name;
		this.introduce = introduce;
		this.sex = sex;
		this.blood =blood;
		this.email = email;
		this.phone = phone;
		this.birthday= birthday;
	}
	
	
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
