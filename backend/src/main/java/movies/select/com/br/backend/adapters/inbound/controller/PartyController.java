package movies.select.com.br.backend.adapters.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.party.*;
import movies.select.com.br.backend.application.usecase.party.PartyUseCase;
import movies.select.com.br.backend.domain.party.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/parties")
@RequiredArgsConstructor
public class PartyController implements PartyUseCase {

    private final CreatePartyServiceImpl createPartyService;
    private final ListUserPartiesServiceImpl listUserPartiesService;
    private final RemovePartyServiceImpl removePartyService;
    private final DetailPartyServiceImpl detailPartyService;
    private final CreatePartyOrderServiceImpl createPartyOrderService;
    private final ListPartyOrdersServiceImpl listPartyOrdersService;
    private final AcceptPartyOrderServiceImpl acceptPartyOrderService;
    private final GiveModeratorServiceImpl giveModeratorService;

    @PostMapping
    @ResponseStatus(CREATED)
    @Override
    public PartyResponse create(
            @Valid @RequestBody PartyRequest request,
            @CookieValue("ACCESS_TOKEN") String token) {
        return this.createPartyService.create(request, token);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    @Override
    public void remove(@CookieValue("ACCESS_TOKEN") String token, UUID id) {
        this.removePartyService.remove(token, id);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(OK)
    @Override
    public List<PartyResponse> userParties(@PathVariable UUID id) {
        return this.listUserPartiesService.list(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Override
    public PartyDetailResponse detail(@PathVariable UUID id) {
        return this.detailPartyService.detail(id);
    }

    @PutMapping("/{partyId}/users/{userId}")
    @ResponseStatus(OK)
    @Override
    public void giveModerator(
            @PathVariable UUID partyId,
            @PathVariable UUID userId,
            @CookieValue("ACCESS_TOKEN") String token) {
        this.giveModeratorService.give(partyId, userId, token);
    }

    @PostMapping("/{id}/orders")
    @ResponseStatus(CREATED)
    @Override
    public PartyOrderResponse createOrder(
            @PathVariable UUID id,
            @CookieValue("ACCESS_TOKEN") String token) {
        return this.createPartyOrderService.create(id, token);
    }

    @GetMapping("/{id}/orders")
    @ResponseStatus(OK)
    @Override
    public List<PartyOrderResponse> listPartyOrders(
            @PathVariable UUID id,
            @CookieValue("ACCESS_TOKEN") String token) {
        return this.listPartyOrdersService.list(id, token);
    }

    @PutMapping("/orders/{orderId}")
    @ResponseStatus(ACCEPTED)
    @Override
    public void acceptOrder(UUID orderId, String token) {
        this.acceptPartyOrderService.accept(orderId, token);
    }
}
