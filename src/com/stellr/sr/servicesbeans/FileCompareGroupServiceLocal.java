package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.FileCompareGroup;
import javax.ejb.Local;

/* File Compare Group Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface FileCompareGroupServiceLocal {
	public void createFileCompareGroup(FileCompareGroup newFileCompareGroup);

	public void updateFileCompareGroup(FileCompareGroup FileCompareGroup);

	public FileCompareGroup fetchFileCompareGroupbyId(int FileCompareGroupId);

	public List<FileCompareGroup> getAllFileCompareGroup();
}
