package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.FilePath;
import com.stellr.sr.domain.SRMailGroup;
import javax.ejb.Local;

/* File Path Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface SRMailGroupServiceLocal {
	public void createSRMailGroup(SRMailGroup newGroup);

	public void updateSRMailGroup(SRMailGroup group);

	public SRMailGroup fetchSRMailGroupbyId(int groupId);

	public List<SRMailGroup> getAllSRMailGroup();
}
