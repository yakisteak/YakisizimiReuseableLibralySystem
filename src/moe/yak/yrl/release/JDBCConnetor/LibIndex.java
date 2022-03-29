package moe.yak.yrl.release.JDBCConnetor;

import moe.yak.yrl.libraryTemplate.TemplateMain;

public class LibIndex extends TemplateMain{
	private long version = 0001;
	private String title = "JDBCConnector";
	private String author = "Yakisizimi";
	private String description = "デスクリプション";
	public long getVersion() {
		return version;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDescription() {
		return description;
	}
}
