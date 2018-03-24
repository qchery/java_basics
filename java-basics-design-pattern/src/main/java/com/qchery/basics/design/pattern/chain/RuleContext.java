package com.qchery.basics.design.pattern.chain;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:00
 */
public class RuleContext {

    private LoanApplyFact loanApplyFact;

    private PbccReportFact pbccReportFact;

    public LoanApplyFact getLoanApplyFact() {
        return loanApplyFact;
    }

    public void setLoanApplyFact(LoanApplyFact loanApplyFact) {
        this.loanApplyFact = loanApplyFact;
    }

    public PbccReportFact getPbccReportFact() {
        return pbccReportFact;
    }

    public void setPbccReportFact(PbccReportFact pbccReportFact) {
        this.pbccReportFact = pbccReportFact;
    }
}
