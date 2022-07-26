package com.springbootproject.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination {



	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pageable getPagination(String pageNo, String size) {

		return PageRequest.of(Integer.parseInt(pageNo) - 1, Integer.parseInt(size));

	}

}


