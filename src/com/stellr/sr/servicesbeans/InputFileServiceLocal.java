package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.InputFile;
import javax.ejb.Local;

/* Input File Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface InputFileServiceLocal {
	public void createNewInputFile(InputFile newInputFile);

	public void updateInputFile(InputFile inputFile);

	public InputFile fetchInputFilebyId(int inputFileId);

	public List<InputFile> getAllInputFiles();
}
