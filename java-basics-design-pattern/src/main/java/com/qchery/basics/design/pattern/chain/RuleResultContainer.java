package com.qchery.basics.design.pattern.chain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:04
 */
public class RuleResultContainer {

    private Set<RuleResult> ruleResults = new LinkedHashSet<>();

    public void add(RuleResult ruleResult) {
        ruleResults.add(ruleResult);
    }

    public Set<RuleResult> getRuleResults() {
        return ruleResults;
    }

    public boolean isReject() {
        return ruleResults.stream()
                .anyMatch(ruleResult -> RuleResult.CODE_REJECT == ruleResult.getCode());
    }

    @Override
    public String toString() {
        return "RuleResultContainer{" +
                "ruleResults=" + ruleResults +
                '}';
    }
}
