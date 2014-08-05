package org.precondition.dao;

import org.precondition.model.UcenterPreconditionEvent;
import org.drools.KnowledgeBase;

import java.util.Map;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public interface UcenterRuleDao {
    KnowledgeBase getUcenterPreconditionRuleByType(UcenterPreconditionEvent type);

    Map<UcenterPreconditionEvent, KnowledgeBase> getAllUcenterPreconditionRule();


}
