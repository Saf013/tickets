package org.hillel.service;

import org.hillel.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TicketClient {

    @Autowired
    private TransactionalJourneyService transactionalJourneyService;

    @Autowired
    private TransactionalVehicleService vehicleService;

    @Autowired
    private TransactionalFreePlaces freePlaces;

    @Autowired
    private TransactionalStopService stopService;

    @Autowired
    private TransactionalStopAddService stopAddService;

    public JourneyEntity createOrUpdate(final JourneyEntity journeyEntity) {
        return transactionalJourneyService.createOrUpdate(journeyEntity);
    }

    public Collection<JourneyEntity> findAllJourneys(){
        return transactionalJourneyService.findAll();
    }

    public Collection<JourneyEntity> findAllAsNativeJourneys(){
        return transactionalJourneyService.findAllAsNative();
    }

    public Collection<JourneyEntity> findAllAsCriteriaJourneysPageSort(int page, int pageSize, String exp, boolean ascen){
        return transactionalJourneyService.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    public Collection<JourneyEntity> findAllAsNamedQueryJourneys(String name){
        return transactionalJourneyService.findAllAsNamedQuery(name);
    }

    public Collection<JourneyEntity> findAllJourneysAsStoredProcedure() {
        return transactionalJourneyService.findAllAsStoredProcedure();
    }

    public Collection<JourneyEntity> findAllAsProcedure() {
        return transactionalJourneyService.findAllAsStoredProcedure();
    }

    public VehicleEntity createOrUpdate(final VehicleEntity vehicleEntity) {
        return vehicleService.createOrUpdate(vehicleEntity);
    }

    public Collection<VehicleEntity> findAllVehicles(){
        return vehicleService.findAll();
    }

    public Collection<VehicleEntity> findAllAsNativeVehicles(){
        return vehicleService.findAllAsNative();
    }

    public Collection<VehicleEntity> findAllAsCriteriaVehiclesPageSort(int page, int pageSize, String exp, boolean ascen){
        return vehicleService.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    public Collection<VehicleEntity> findAllAsNamedQueryVehicles(String name){
        return vehicleService.findAllAsNamedQuery(name);
    }

    public Collection<VehicleEntity> findAllVehiclesAsStoredProcedure() {
        return vehicleService.findAllAsStoredProcedure();
    }

    public void removeVehicle(VehicleEntity entity) {
        vehicleService.remove(entity);
    }

    public Collection<VehicleEntity> findAllVehiclesMinPlaces(){
        return vehicleService.findAllVehiclesMinPlaces();
    }

    public Collection<VehicleEntity> findAllVehiclesMaxPlaces(){
        return vehicleService.findAllVehiclesMaxPlaces();
    }

    public FreePlacesEntity createOrUpdate(FreePlacesEntity freePlacesEntity) {
        return freePlaces.createOrUpdate(freePlacesEntity);
    }

    public Collection<FreePlacesEntity> findAllPlaces(){
        return freePlaces.findAll();
    }

    public Collection<FreePlacesEntity> findAllAsNativePlaces(){
        return freePlaces.findAllAsNative();
    }

    public Collection<FreePlacesEntity> findAllAsCriteriaPlacesPageSort(int page, int pageSize, String exp, boolean ascen){
        return freePlaces.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    public Collection<FreePlacesEntity> findAllAsNamedQueryPlaces(String name){
        return freePlaces.findAllAsNamedQuery(name);
    }

    public Collection<FreePlacesEntity> findAllPlacesAsStoredProcedure() {
        return freePlaces.findAllAsStoredProcedure();
    }

    public StopEntity createOrUpdate(StopEntity stopEntity) {
        return stopService.createOrUpdate(stopEntity);
    }

    public void removeStop(StopEntity stopEntity) {
        stopService.remove(stopEntity);
    }

    public Collection<StopEntity> findAllStops(){
        return stopService.findAll();
    }

    public Collection<StopEntity> findAllAsNativeStops(){
        return stopService.findAllAsNative();
    }

    public Collection<StopEntity> findAllAsCriteriaStopsPageSort(int page, int pageSize, String exp, boolean ascen){
        return stopService.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    public Collection<StopEntity> findAllAsNamedQueryStops(String name){
        return stopService.findAllAsNamedQuery(name);
    }

    public Collection<StopEntity> findAllStopsAsStoredProcedure() {
        return stopService.findAllAsStoredProcedure();
    }

    public Collection<StopAddInfoEntity> findAllStopsInfo(){
        return stopAddService.findAll();
    }

    public Collection<StopAddInfoEntity> findAllAsNativeStopsInfo(){
        return stopAddService.findAllAsNative();
    }

    public Collection<StopAddInfoEntity> findAllAsCriteriaStopsInfoPageSort(int page, int pageSize, String exp, boolean ascen){
        return stopAddService.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    public Collection<StopAddInfoEntity> findAllAsNamedQueryStopsInfo(String name){
        return stopAddService.findAllAsNamedQuery(name);
    }

    public Collection<StopAddInfoEntity> findAllStopsInfoAsStoredProcedure() {
        return stopAddService.findAllAsStoredProcedure();
    }
}
