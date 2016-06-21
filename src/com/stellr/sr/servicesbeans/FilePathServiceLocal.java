package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.FilePath;
import javax.ejb.Local;

/* File Path Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface FilePathServiceLocal {
	public void createFilePath(FilePath newFilePath);

	public void updateFilePath(FilePath FilePath);

	public FilePath fetchFilePathbyId(int FilePathId);

	public List<FilePath> getAllFilePath();
}
