package org.cwf.mapper;

import org.apache.ibatis.annotations.Param;

public interface DocumentDeployMapper {
	
	int selectDocumentDeploy();
	
	Integer deleteDocumentDeploy();
	
	Integer updateDocumentDeploy(@Param("id") int id,@Param("score") int score);
}
