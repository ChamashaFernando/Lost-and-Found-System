package lk.chamasha.lost.and.found.service;

import lk.chamasha.lost.and.found.controller.request.ClaimRequestRequest;
import lk.chamasha.lost.and.found.controller.response.ClaimRequestResponse;

import java.util.List;

public interface ClaimRequestService {
    ClaimRequestResponse createClaim(ClaimRequestRequest request);
    List<ClaimRequestResponse> getClaimsByItem(Long itemId);
    void approveClaim(Long claimId);
}
