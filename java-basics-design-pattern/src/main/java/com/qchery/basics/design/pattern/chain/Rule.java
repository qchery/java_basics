package com.qchery.basics.design.pattern.chain;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:03
 */
public interface Rule {

    /**
     * 规则执行前
     *
     * @param ruleContext         规则上下文
     * @param ruleResultContainer 规则结果
     * @param ruleChain           规则执行链
     */
    void doBefore(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain);

    /**
     * 规则执行
     *
     * @param ruleContext         规则上下文
     * @param ruleResultContainer 规则结果
     * @param ruleChain           规则执行链
     */
    void doExecute(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain);

    /**
     * 规则执行前
     *
     * @param ruleContext         规则上下文
     * @param ruleResultContainer 规则结果
     * @param ruleChain           规则执行链
     */
    void doAfter(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain);
}
