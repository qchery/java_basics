package com.qchery.basics.design.pattern.chain;

import com.qchery.basics.design.pattern.chain.impl.ErrorRule;
import com.qchery.basics.design.pattern.chain.impl.RejectRule;
import com.qchery.basics.design.pattern.chain.impl.WarnRule;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:24
 */
public class RuleChainTest {

    public static void main(String[] args) {
        RuleChain ruleChain = new RuleChain();
        ruleChain.addUnit(new WarnRule());
        ruleChain.addUnit(new RejectRule());
        ruleChain.addUnit(new ErrorRule());

        RuleChain subChain = new RuleChain();
        subChain.addUnit(new WarnRule());
        ruleChain.addUnit(subChain);

        RuleContext ruleContext = new RuleContext();

        RuleResultContainer container = new RuleResultContainer();
        ruleChain.setStopWhenReject(true);
        ruleChain.doExecute(ruleContext, container, ruleChain);
        System.out.println(container);
    }

}
