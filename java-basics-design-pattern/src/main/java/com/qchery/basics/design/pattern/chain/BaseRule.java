package com.qchery.basics.design.pattern.chain;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:30
 */
public abstract class BaseRule implements Rule {

    @Override
    public void doBefore(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain) {
        System.out.println(this.toString() + " Start");
    }

    @Override
    public void doAfter(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain) {
        System.out.println(this.toString() + " End");
    }

}
