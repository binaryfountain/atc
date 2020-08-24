# Airplane

## Objective
Using Spring Boot, develop an Air Traffic Control system (ATCS) that meets the requirements listed below. The ATCS will allow the queuing and dequeuing of aircraft (AC).

## Layers
The ATCS should have the following layers,

1. REST layer
    1. This layer provides access to the ATCS.
    1. It should provide endpoints for all of the ATC methods.
    1. Appropriate error messages should be displayed / returned.
    1. It must be a RESTful interface.
1. Logic layer
    1. This layer provides the logical operations of the ATCS.
    1. It should provide the following functions
        1. List – Provide the current order of the AC in the queue
        1. Enqueue – Add an AC to the queue
        1. Dequeue- Remove an AC from the queue based on priority
    1. This layer will contain the queue object

## Objects
The ATCS should have the following objects with the listed properties,

1. Aircraft (AC)
    1. ID
        * This field will store the AC id
    1. Type
        * Emergency, VIP, Passenger, or Cargo
    1. Size
        * Small or Large

## Dequeue Logic
The ATCS should dequeue planes with the following logic
1. Emergency AC always have the highest priority.
1. VIP are more important than other types, except Emergency
1. Passenger ACs have a higher priority than Cargo ACs.
1. Large ACs of a given type have priority over Small ACs of the same type.
1. Earlier enqueued ACs of a given type and size have precedence over later enqueued ACs of the same type and size.

## Notes
1. There are `TODO`s to mark areas where code needs to be filled in 