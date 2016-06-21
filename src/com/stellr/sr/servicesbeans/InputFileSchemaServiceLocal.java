package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.InputFileSchema;
import javax.ejb.Local;

/* Input File Schema Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface InputFileSchemaServiceLocal {
	public void createInputFileSchema(InputFileSchema newInputFileSchema);

	public void updateInputFileSchema(InputFileSchema inputFileSchema);

	public InputFileSchema fetchInputFileSchemabyId(int InputFileSchemaId);

	public List<InputFileSchema> getAllInputFileSchema();
}
