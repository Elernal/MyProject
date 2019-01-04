package org.cwf.model;

import com.github.pagehelper.PageInfo;

import lombok.Data;

@Data
public class JsonUser {
	private PageInfo<User> pageList;
	private int code;
	private String msg;
	private String name;
	private String sex;
	private int page;
	private int limit;
}

