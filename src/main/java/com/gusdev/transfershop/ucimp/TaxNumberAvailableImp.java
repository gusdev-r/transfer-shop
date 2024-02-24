package com.gusdev.transfershop.ucimp;

import com.gusdev.transfershop.gateway.TaxNumberAvailableGw;
import com.gusdev.transfershop.usecase.TaxNumberAvailableUc;

public class TaxNumberAvailableImp implements TaxNumberAvailableUc {
    private TaxNumberAvailableGw taxNumberAvailableGw;

    public TaxNumberAvailableImp(TaxNumberAvailableGw taxNumberAvailableGw) {
        this.taxNumberAvailableGw = taxNumberAvailableGw;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGw.taxNumberAvailable(taxNumber);
    }
}
