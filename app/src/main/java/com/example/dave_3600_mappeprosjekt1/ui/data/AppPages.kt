package com.example.dave_3600_mappeprosjekt1.ui.data

/**
 * Enum som representerer de forskjellige sidene i applikasjonen.
 *
 * Brukes av navigasjonssystemet (NavHostController) for å identifisere og navigere til de ulike skjermene.
 *
 * Verdier:
 * - [Home]: Hovedsiden med startknapper for navigasjon.
 * - [Game]: Spillsiden hvor brukeren løser oppgaver.
 * - [About]: Side med informasjon om applikasjonen.
 * - [Preference]: Side hvor brukeren kan endre spillengde.
 */
enum class AppPages {
    Home,
    Game,
    About,
    Preference
}
