import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BylyricsComponent } from './bylyrics.component';

describe('BylyricsComponent', () => {
  let component: BylyricsComponent;
  let fixture: ComponentFixture<BylyricsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BylyricsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BylyricsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
