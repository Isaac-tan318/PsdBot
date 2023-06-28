package com.PS.PsdBot;

//public class ReactiveBotConfig {
//
//    public static GatewayDiscordClient client = DiscordClientBuilder.create("OTYxOTYxMDczMTk0NDY3MzY4.GdlUrJ.x3-emM2s7vbOpFjqHiYZnkcK8nwnhjYbk5DQAg")
//            .build()
//            .login()
//            .block();
//
//    public void runBot() {
//        client.getEventDispatcher().on(MessageCreateEvent.class)
//                .flatMap(event -> Mono.justOrEmpty(event.getMessage().getContent())
//                        .flatMap(content -> {
//                            List<String> splitMsg = Arrays.stream(content.split("\\s+")).map(String::toLowerCase).toList();
//
//                                    Mono<Void> inCmd = Flux.fromIterable(Arrays.asList(InCmd.values()))
//                                            .filter(value -> splitMsg.contains(value.name().toLowerCase(Locale.ROOT)))
//                                            .flatMap(value -> value.execute(event, splitMsg))
//                                            .next();
//
//                            Mono<Void> cmd = Flux.fromIterable(Arrays.asList(Cmd.values()))
//                                    .filter(value -> content.equals("!"+value.name().toLowerCase(Locale.ROOT)))
//                                    .flatMap(entry -> entry.execute(event))
//                                    .next();
//
//                            return inCmd.switchIfEmpty(cmd);
//                        }
//                        )
//                ).subscribe();
//
//
//        client.onDisconnect().map(unused -> {
//            System.out.println("poopoo");
//            return unused;
//        }).block();
//    }
//
//}
