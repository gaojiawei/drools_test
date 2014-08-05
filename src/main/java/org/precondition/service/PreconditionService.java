package org.precondition.service;

import org.precondition.model.Result;
import org.precondition.model.UcenterPreconditionObject;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public interface PreconditionService {
        public Result preProcess(UcenterPreconditionObject riskObject);

    public void postProcess(UcenterPreconditionObject riskObject);
}
