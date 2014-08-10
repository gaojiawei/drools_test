package org.precondition.service;

import org.precondition.model.RiskResult;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public interface RiskControlService {
        public RiskResult RiskAssess();

    public void postProcess();
}
