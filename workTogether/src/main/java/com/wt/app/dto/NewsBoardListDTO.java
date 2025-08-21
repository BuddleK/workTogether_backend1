package com.wt.app.dto;

import java.util.List;

import com.example.app.dto.FileDTO;

public class NewsBoardListDTO {
	private int usersNumber;
	private String usersId;
	private int NewsboardNumber;
	private String NewsboardTitle;
	private String NewsboardContent;
	private String NewsboardDate;
	private int boardReadCount;
	private List<FileDTO> files;
}
