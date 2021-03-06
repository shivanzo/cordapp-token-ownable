package com.template

import net.corda.core.contracts.CommandAndState
import net.corda.core.contracts.OwnableState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

data class TokenState(
        val amount: Int,
        override val owner: AbstractParty,
        override val participants: List<AbstractParty>): OwnableState {

    override fun withNewOwner(newOwner: AbstractParty): CommandAndState {
        return CommandAndState(TokenContract.Commands.Transfer(), this.copy(owner = newOwner))
    }

}