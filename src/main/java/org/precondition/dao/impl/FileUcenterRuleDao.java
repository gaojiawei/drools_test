package org.precondition.dao.impl;

import org.precondition.dao.UcenterRuleDao;
import org.precondition.model.UcenterPreconditionType;
import org.drools.KnowledgeBase;

import java.util.Map;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public class FileUcenterRuleDao implements UcenterRuleDao {
    @Override
    public KnowledgeBase getUcenterPreconditionRuleByType(UcenterPreconditionType type) {
        return null;  //TODO
    }

    @Override
    public Map<UcenterPreconditionType, KnowledgeBase> getAllUcenterPreconditionRule() {
        return null;  //TODO
    }
}
