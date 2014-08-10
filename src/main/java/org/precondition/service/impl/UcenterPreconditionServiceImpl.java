package org.precondition.service.impl;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.precondition.model.Result;
import org.precondition.model.UcenterPreconditionObject;
import org.precondition.model.wrapper.UcenterPreconditionObjectWrapper;
import org.precondition.service.PreconditionService;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public class UcenterPreconditionServiceImpl extends UcenterAbstractDroolsImpl implements PreconditionService {
    @Override public Result preProcess(UcenterPreconditionObject riskObject) {
        StatelessKnowledgeSession session = this
                .getSessionByUcenterPreconditionType(riskObject.getEvent());
        UcenterPreconditionObjectWrapper wrapper = new UcenterPreconditionObjectWrapper(riskObject);
        wrapper.setValidateResult(new Result(0));
        session.execute(wrapper);
        return wrapper.getValidateResult();
    }

    @Override public void postProcess(UcenterPreconditionObject riskObject) {
        KnowledgeBase knowledgeBase = getUcenterPreconditionRoles().get(riskObject.getEvent());
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.setGlobal("limter", getLimiter());
        session.setGlobal("logger",logger);
        UcenterPreconditionObjectWrapper wrapper = new UcenterPreconditionObjectWrapper(riskObject,true);
        wrapper.setValidateResult(new Result(0));
        session.insert(wrapper);
        session.fireAllRules();
        session.dispose();
    }

}
