package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.ConcatenateFileGroup;
import javax.ejb.Local;

/* Concatenate File Group Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface ConcatenateFileGroupServiceLocal {
	public void createConcatenateFileGroup(ConcatenateFileGroup newGroup);

	public void updateConcatenateFileGroup(ConcatenateFileGroup group);

	public ConcatenateFileGroup fetchConcatenateFileGroupbyId(int groupId);

	public List<ConcatenateFileGroup> getAllConcatenateFileGroup();
}
