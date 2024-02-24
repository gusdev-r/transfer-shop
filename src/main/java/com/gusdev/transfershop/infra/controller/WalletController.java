package com.gusdev.transfershop.infra.controller;

import com.gusdev.transfershop.infra.dto.request.TransferRequest;
import com.gusdev.transfershop.infra.dto.response.BaseResponse;
import com.gusdev.transfershop.infra.dto.response.ConsultBalanceResponse;
import com.gusdev.transfershop.usecase.ConsultBalanceUc;
import com.gusdev.transfershop.usecase.TransferUc;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/wallets")
public class WalletController {

    private ConsultBalanceUc consultBalanceUc;
    private TransferUc transferUc;

    public WalletController(ConsultBalanceUc consultBalanceUc, TransferUc transferUc) {
        this.consultBalanceUc = consultBalanceUc;
        this.transferUc = transferUc;
    }
    @GetMapping("/consult-balance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUc.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transferValue(@RequestBody TransferRequest transferRequest) throws Exception {
        transferUc.transfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber(), transferRequest.value(), transferRequest.pin());
        return BaseResponse.<String>builder().success(true).message("Successful transfer.").build();
    }
}
