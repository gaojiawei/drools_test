package org.precondition.dao;

import org.precondition.model.UcenterPreconditionType;
import org.drools.KnowledgeBase;

import java.util.Map;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public interface UcenterRuleDao {
    KnowledgeBase getUcenterPreconditionRuleByType(UcenterPreconditionType type);

    Map<UcenterPreconditionType, KnowledgeBase> getAllUcenterPreconditionRule();


}
