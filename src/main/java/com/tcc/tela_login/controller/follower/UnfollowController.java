//package com.tcc.tela_login.controller.follower;
//
//import com.tcc.tela_login.service.follower.FollowingService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/unfollow")
//public class UnfollowController {
//
//    private final FollowingService friendService;
//
//    @PostMapping("/{id}")
//    ResponseEntity<String> unfollow(@PathVariable String id, @RequestParam String playerName) {
//        friendService.unfollow(id, playerName);
//        return ResponseEntity.ok("Você deixou de seguir esse jogador!");
//    }
//}
