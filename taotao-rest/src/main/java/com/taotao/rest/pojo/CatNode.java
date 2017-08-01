package com.taotao.rest.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CatNode {

	@JsonProperty("n")
    private String name;
	@JsonProperty("u")
	private String url;
	@JsonProperty("i")
	private List<?> item;
}
