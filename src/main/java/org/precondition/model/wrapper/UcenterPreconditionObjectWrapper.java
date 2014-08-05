package org.precondition.model.wrapper;

import org.precondition.model.Result;
import org.precondition.model.UcenterPreconditionObject;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public class UcenterPreconditionObjectWrapper extends UcenterPreconditionObject {
    private Result result ;

    private boolean postProcess;

    public UcenterPreconditionObjectWrapper(UcenterPreconditionObject object){
        this(object,false);
    }

    public UcenterPreconditionObjectWrapper(UcenterPreconditionObject object, boolean postProcess){
        setUsername(object.getUsername());
        setIp(object.getIp());
        setEvent(object.getEvent());
        setType(object.getType());
        this.postProcess = postProcess;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isPostProcess() {
        return postProcess;
    }

    public void setPostProcess(boolean postProcess) {
        this.postProcess = postProcess;
    }
}
