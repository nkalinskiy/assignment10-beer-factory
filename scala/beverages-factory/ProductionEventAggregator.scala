import cats.effect.kernel.Ref
import cats.effect.IO

trait ProductionEventAggregator {
  // Метод принимает результат производтсва одного напитка и сохраняет его в общий список всех событий со всех фабрик
  def receiveProductionEvent(productionEvent: ProductionEvent): IO[Unit]

  // Получить список всех событий, которые были сохранены в агрегаторе
  def getAllEvents(): IO[List[ProductionEvent]]
}

object ProductionEventAggregator {
  private class Impl(state: Ref[IO, List[ProductionEvent]])
      extends ProductionEventAggregator {

    override def receiveProductionEvent(
        productionResult: ProductionEvent
    ): IO[Unit] =
      state.update(_ :+ productionResult)

    override def getAllEvents(): IO[List[ProductionEvent]] =
      state.get
  }

  // Метод для создания аггрегатора результатов производства.
  // Вызывать его нужно один раз в мейне программы, чтобы был всего один объект на всю программу.
  // Ref это аналог AtomicRef, только из ФП
  def makeAggregator: IO[ProductionEventAggregator] =
    Ref[IO].of(List.empty[ProductionEvent]).map(new Impl(_))
}
