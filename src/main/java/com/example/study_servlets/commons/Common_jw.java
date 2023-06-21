package com.example.study_servlets.commons;

import java.util.UUID;

public class Common_jw {
    public static final String CAR_INFOR_IDUUID = null;

	public static String CAR_INFOR_IDUUID() {
        return UUID.randomUUID().toString();
    }
}
/*
 * 유니크 아이디 생성
 */