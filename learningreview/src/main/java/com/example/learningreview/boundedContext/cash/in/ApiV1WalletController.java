package com.example.learningreview.boundedContext.cash.in;

import com.example.learningreview.boundedContext.cash.app.CashFacade;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.shared.cash.dto.WalletDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cash/")
public class ApiV1WalletController {
    private final CashFacade cashFacade;

    @Transactional(readOnly = true)
    @GetMapping("wallets/by-holder/{holderId}")
    public WalletDto getItemByHolder(@PathVariable("holderId") int holderId){
        return cashFacade.findWalletByHolderId(holderId)
                .map(WalletDto::new)
                .get();
    }
}
