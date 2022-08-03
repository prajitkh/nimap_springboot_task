package com.springbootproject.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.springbootproject.entity.ApiLoggerEntity;
import com.springbootproject.entity.LoggerEntity;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.service.ApiLoggerInterface;
import com.springbootproject.service.LoggerServiceInterface;
import com.springbootproject.serviceImpl.LoggerServiceImpl;



@Component
public class ApiLogger implements HandlerInterceptor{

	@Autowired
	private LoggerServiceInterface loggerServiceInterface;


	@Autowired
	private ApiLoggerInterface apiLoggerInterface;
	Gson gson =new Gson();


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


		String arr[]=request.getRequestURI().split("/");
		String getParam = arr[arr.length - 1];
		String getParam2 = arr[arr.length - 2];


		ArrayList<String> skipUrl=new ArrayList<>(Arrays.asList("/auth/login"+ getParam2 + "/" + getParam));

	
		if(!skipUrl.contains(request.getRequestURI())) {
			System.out.println("token1233+12121");
			final String requestTokenHeader=request.getHeader("Authorization").split(" ")[1];
			System.out.println("token1233"+request.getHeader("Authorization").split(" ")[1]);
			
			LoggerEntity loggerEntity= loggerServiceInterface.getLoggerDetail(requestTokenHeader);



			if(loggerEntity ==null) {

				ErrorResponseDto responseDto=new ErrorResponseDto("WRONG ", " EXISITING NOT FOUND" );
				String jsonString=gson.toJson(responseDto);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(jsonString);
				return false;
			}
			else 
			{
				ApiLoggerEntity apiLoggerEntity=new ApiLoggerEntity();

				apiLoggerEntity.setUserToken(requestTokenHeader);
				apiLoggerEntity.setIpAddress(request.getRemoteAddr());
				apiLoggerEntity.setUrl(request.getRequestURI());
				apiLoggerEntity.setMethod(request.getMethod());
				apiLoggerEntity.setHost(request.getRemoteHost());
				apiLoggerEntity.setBody(request instanceof StandardMultipartHttpServletRequest ? null : request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
				apiLoggerInterface.createApilog(requestTokenHeader);
				

				return true;
			}

		}

		else {


			return true;
		}

	}


}
