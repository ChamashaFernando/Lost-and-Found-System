//package lk.chamasha.lost.and.found.service.impl;
//
//import lk.chamasha.lost.and.found.controller.request.ClaimRequestRequest;
//import lk.chamasha.lost.and.found.controller.response.ClaimRequestResponse;
//import lk.chamasha.lost.and.found.model.ClaimRequest;
//import lk.chamasha.lost.and.found.model.ClaimStatus;
//import lk.chamasha.lost.and.found.model.Item;
//import lk.chamasha.lost.and.found.model.User;
//import lk.chamasha.lost.and.found.repository.ClaimRequestRepository;
//import lk.chamasha.lost.and.found.repository.ItemRepository;
//import lk.chamasha.lost.and.found.repository.UserRepository;
//import lk.chamasha.lost.and.found.service.ClaimRequestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//@RequiredArgsConstructor
//public class ClaimRequestServiceImpl implements ClaimRequestService {
//    private final ClaimRequestRepository claimRequestRepository;
//    private final UserRepository userRepository;
//    private final ItemRepository itemRepository;
//
//    @Override
//    public ClaimRequestResponse createClaim(ClaimRequestRequest request) {
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        Item item = itemRepository.findById(request.getItemId())
//                .orElseThrow(() -> new RuntimeException("Item not found"));
//        ClaimRequest claim = new ClaimRequest();
//        claim.setUser(user);
//        claim.setItem(item);
//        claim.setStatus(ClaimStatus.PENDING);
//        claim.setDetails(request.getDetails());
//        return mapToResponse(claimRequestRepository.save(claim));
//    }
//
//    @Override
//    public List<ClaimRequestResponse> getClaimsByItem(Long itemId) {
//        return claimRequestRepository.findByItemId(itemId).stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void approveClaim(Long claimId) {
//        ClaimRequest claim = claimRequestRepository.findById(claimId)
//                .orElseThrow(() -> new RuntimeException("Claim not found"));
//        claim.setStatus(ClaimStatus.APPROVED);
//        claimRequestRepository.save(claim);
//    }
//
//    private ClaimRequestResponse mapToResponse(ClaimRequest claim) {
//        return new ClaimRequestResponse(claim.getId(), claim.getUser().getId(), claim.getItem().getId(),
//                claim.getDetails(), claim.getStatus());
//    }
//}
