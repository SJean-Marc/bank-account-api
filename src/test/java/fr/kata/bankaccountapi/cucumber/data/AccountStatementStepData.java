package fr.kata.bankaccountapi.cucumber.data;

import fr.kata.bankaccountapi.application.dto.AccountStatementDto;

public class AccountStatementStepData {
    private static AccountStatementDto[] accountStatements;

    public static void setAccountStatements(AccountStatementDto[] accountStatements) {
        AccountStatementStepData.accountStatements = accountStatements;
    }

    public static AccountStatementDto[] getAccountStatements() {
        return accountStatements;
    }
}
