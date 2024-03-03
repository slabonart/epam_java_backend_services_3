package pl.slabonart.epam_java_backend_services_3.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionResponseDto;


import java.util.List;

@Api(value = "Subscription Controller", description = "Rest API related to Subscription entity", tags = "Subscription API")
public interface SubscriptionController {

    @PostMapping(
            path = "/subscription",
            produces = "application/json",
            consumes = "application/json"
    )
    @ApiOperation(value = "Allows to create new subscription for given user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 404, message = "User not found!!!")})
    ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto);

    @PutMapping(value = "/subscription/{id}", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Allows to update existing subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 404, message = "Subscription or User not found!!!")})
    ResponseEntity<SubscriptionResponseDto> updateSubscription(@PathVariable Long id, @RequestBody SubscriptionRequestDto subscriptionRequestDto);

    @DeleteMapping(value = "/subscription/{id}", produces = "application/json")
    @ApiOperation(value = "Allows to delete existing subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | User deleted"),
            @ApiResponse(code = 400, message = "Subscription not found!!!") })
    void deleteSubscription(@PathVariable Long id);

    @GetMapping(value = "/subscription/{id}", produces = "application/json")
    @ApiOperation(value = "Get existing subscription resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 404, message = "Subscription not found!!!") })
    ResponseEntity<SubscriptionResponseDto> getSubscription(@PathVariable Long id);

    @GetMapping(value = "/subscriptions", produces = "application/json")
    @ApiOperation(value = "Get all existing subscriptions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = SubscriptionResponseDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "not found!!!") }) //?
    ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions();
}
