package com.qchery.basics.design.pattern.chain.impl;

import com.qchery.basics.design.pattern.chain.*;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:23
 */
public class RejectRule extends BaseRule {
    @Override
    public void doExecute(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain rule) {
        ruleResultContainer.add(new RuleResult(RuleResult.CODE_REJECT, "Reject"));
    }
}
