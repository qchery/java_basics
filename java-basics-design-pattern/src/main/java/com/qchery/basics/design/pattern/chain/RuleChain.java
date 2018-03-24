package com.qchery.basics.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:10
 */
public class RuleChain extends BaseRule {

    private List<Rule> rules = new ArrayList<>();

    private int index;

    private boolean stopWhenReject = true;

    @Override
    public void doExecute(RuleContext ruleContext, RuleResultContainer ruleResultContainer, RuleChain ruleChain) {
        if (index < rules.size()) {
            Rule rule = rules.get(index++);
            rule.doBefore(ruleContext, ruleResultContainer, ruleChain);
            rule.doExecute(ruleContext, ruleResultContainer, ruleChain);
            // 判断是否需要继续执行规则
            if (!ruleResultContainer.isReject() || !stopWhenReject) {
                ruleChain.doExecute(ruleContext, ruleResultContainer, ruleChain);
            }
            rule.doAfter(ruleContext, ruleResultContainer, ruleChain);
        }
    }

    public void addUnit(Rule rule) {
        rules.add(rule);
    }

    public void setStopWhenReject(boolean stopWhenReject) {
        this.stopWhenReject = stopWhenReject;
    }
}
