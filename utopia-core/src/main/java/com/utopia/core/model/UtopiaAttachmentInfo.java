package com.utopia.core.model;

import java.io.File;
import java.io.Serializable;

public class UtopiaAttachmentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4090548305438684697L;
	private File file;
	private String fileName;
	private long fileSize;
	private long attachmentId;
	private boolean isRemoved;
	public UtopiaAttachmentInfo(){
		
	}
	public UtopiaAttachmentInfo(File file,String fileName){
		this(file);
		setFileName(fileName);
	}
	public UtopiaAttachmentInfo(String fileName,long fileSize){
		setFileName(fileName);
		setFileSize(fileSize);
	}
	public UtopiaAttachmentInfo(File f){
		setFile(f);
		setFileName(f.getName());
		setFileSize(f.length());
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public long getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}
	public boolean isRemoved() {
		return isRemoved;
	}
	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}
	
	
}
