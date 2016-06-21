package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.FieldFunction;
import javax.ejb.Local;

/* Field Function Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface FieldFunctionServiceLocal {
	public void createFieldFunction(FieldFunction newFieldFunction);

	public void updateFieldFunction(FieldFunction fieldFunction);

	public FieldFunction fetchFieldFunctionbyId(int fieldFunctionId);

	public List<FieldFunction> getAllFieldFunction();
}
